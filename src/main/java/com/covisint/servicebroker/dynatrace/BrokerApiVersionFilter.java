package com.covisint.servicebroker.dynatrace;

import com.github.zafarkhaja.semver.Version;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Class: BrokerApiVersionFilter.java
 * Description: This is the Filter class which verify the request headers before reaching controller
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */
final class BrokerApiVersionFilter extends OncePerRequestFilter {

    private static final String HEADER = "X-Broker-Api-Version";

    private static final String VALID_VERSIONS = "~2.3";

    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {

        String header = request.getHeader(HEADER);
        if (header == null) {
            response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED);
            return;
        }

        Integer[] parsed = parse(header);
        Version version = Version.forIntegers(parsed[0], parsed[1]);
        if (!version.satisfies(VALID_VERSIONS)) {
            response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED);
            return;
        }

        filterChain.doFilter(request, response);
    }
    /**
     * 
     * @param header
     * @return Integer array
     */
    private Integer[] parse(String header) {
        return Stream.of(header.split("\\.")).map(Integer::parseInt).toArray(Integer[]::new);
    }

}

# Encoding: utf-8
# Cloud Foundry Java Buildpack
# Copyright 2013 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

require 'fileutils'
require 'java_buildpack/component/versioned_dependency_component'
require 'java_buildpack/framework'
require 'java_buildpack/container/tomcat/YamlParser'

module JavaBuildpack
  module Framework

   
    class JceSupport < JavaBuildpack::Component::VersionedDependencyComponent
      
      # @param [Hash] context a collection of utilities used the component
      def initialize(context)
        @application    = context[:application]
        @component_name = self.class.to_s.space_case
        @configuration  = context[:configuration]
        @droplet        = context[:droplet]
        YamlParser.new(context)
      end
	  
	  # (see JavaBuildpack::Component::BaseComponent#detect)
      def detect
        @version, @uri             = JavaBuildpack::Repository::ConfiguredItem.find_item(@component_name,
                                                                                         find_jce_version_config)
        
        super
      end

      
	  
	  # (see JavaBuildpack::Component::BaseComponent#compile)
      def compile
        download_zip
        FileUtils.cp_r("/tmp/staged/app/.java-buildpack/jce_support/.", "/tmp/staged/app/.java-buildpack/oracle_jre/jre/lib/security")
      end

      # (see JavaBuildpack::Component::BaseComponent#release)
      def release
       
      end
	  
	  
       def supports?
        true
      end
    def find_jce_version_config
         if !@configuration.key?$configapp 
         $configapp='openjdk8'
         end      
         @configuration=@configuration[$configapp]
      end 
     
    end

  end
end

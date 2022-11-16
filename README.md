# Introduction

And lo and behold... it arose

Old Imperial, the engine of scribes, toiling to their master Dei

Cogs of a vast empire, they sifted... they churned... they recorded... 

distiling with their pens an elixir that would nurture the dreams of many for decades to come.

# Prerequisites    
    postgres
    groovy
    grails

# versions
    groovy 2.4.7
    gradle 3.5
    java 1.8
    grails 3.3.9
    gormVersion-6.1.5.RELEASE
    grailsWrapperVerion=1.0.0
    gradleWrapperVerion=3.5
    gorm-graphql 1.9.9

# CONFIGULAR
    curl -s get.sdkman.io | bash
    source "$HOME/.sdkman/bin/sdkman-init.sh"
    sdk install grails 3.3.8
    sdk install gradle 3.5
    sdk install groovy 2.4.7

    set GRAILS_HOME and PATH in .profile

    export GRAILS_HOME=/path/to/grails
    export PATH="$PATH:$GRAILS_HOME/bin" 

    details at https://sdkman.io/usage

#To Run

    grails dev run-app    
    http://localhost:8080
    http://localhost:8080/graphql/browser

#To Query
    
    {
      terrainTypeList {
        name
      }
    }
    
    http://myapi/graphql?query={terrainTypeList{name}}
    
    or in a post
    {
      "query": "...",
      "operationName": "...",
      "variables": { "myVariable": "someValue", ... }
    }
    

# Old Imperial

Hosting - Google Cloud Platform, Docker, CircleCi


# TASKS

Diplomacy and Team Workflow - Discourse
    
     Create a Discourse Theme
    
     Create a Custom Layout
    
     Custom Diplomacy Plugins
    
     A shared game board plugin

Turn Processing Tool 
    
    1. Grails & Postgres with a dynamic scaffold
        configure Grails Plugin
        Do a couple of tables a day
        login via grails
    
    2. A player map and interface with vue and element
       Cors
       login via clients
       
    3. Possibly a custom admin interface with React and Blueprint    

    







 
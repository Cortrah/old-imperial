# Introduction

And lo and behold... it arose

Old Imperial, the engine of scribes, toiling to their master Dei

Cogs of a vast empire, they sifted... they churned... they recorded... 

distiling with their pens an elixir that would nurture the dreams of many for decades to come.

# Prerequisites    
    postgres
    groovy
    grails

# CONFIGULAR
    curl -s get.sdkman.io | bash
    should be at
    /Users/cort/.sdkman
    source "$HOME/.sdkman/bin/sdkman-init.sh"
    sdk install grails
    grails -version
    
    which grails
    /Users/cort/.sdkman/candidates/grails/current/bin/grails
    which groovy
    /usr/local/bin/groovy

    set GRAILS_HOME and PATH in .profile

    export GRAILS_HOME=/path/to/grails
    export PATH="$PATH:$GRAILS_HOME/bin" 


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

    







 
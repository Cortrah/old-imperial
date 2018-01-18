#To Run
    
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


# Old Imperial

Overall Todo

Hosting - Google Cloud Platoform, Docker, CircleCi

Marketing
    
    Kickstarter
    
    A book - fun and games with discourse
    
    Swag
    
    Contests
    
    Alliances with established games and creators 
        
        Cruenti Dei
        Mouse Guard
        Eclipse Phase
        Pelikoi

# TASKS

Mobile/Tablet/Bigscreen Layouts

    Make it clickable and transition with turn 23 content.


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

    
Vue client interface
    
    Inline Popup Component for text, processing to automatically create them based on characters, regions and realms
    
    Map Component
    
    Realm Actions
    
    Leader Actions
    
    Processing actions with default narrative and custom narrative


# Technical Process

    Esperiment with Grails Plugin
    
    Get Grails and Graphql working.    
    
    Create a vue project (seperate or monolithic?)

    Try Vue Storybook and element ui
    
    Add inline popup
    
    Add map
   
    Add a leader icon to the map
    
    Have the leader icon be draggable
    
    Have the leader icon have orbit actions
    
    Assemble those actions and post them to the server
    
    Have the server interface process the actions

# Design Process

    do an interface inventory
    
    stub out components for a complete system
    
    compose layouts with the components
    
    







 
<%@ page import="grails.util.Environment" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Old Imperial</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <content tag="nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                Application Status
                <span class="caret">
                </span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="#">Environment: ${Environment.current.name}</a></li>
                <li><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>
                <li><a href="#">App version:
                    <g:meta name="info.app.version"/></a>
                </li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Grails version:
                    <g:meta name="info.app.grailsVersion"/></a>
                </li>
                <li><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
                <li><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Reloading active: ${Environment.reloadingAgentEnabled}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
                <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
                <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
                <li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                    <li><a href="#">${plugin.name} - ${plugin.version}</a></li>
                </g:each>
            </ul>
        </li>
    </content>

    <div id="content" role="main">
        <button onclick="savePositions()" style="margin-top: 10px; margin-left: 10px">
            Save
        </button>
        <button onclick="loadPositions()" style="margin-top: 10px; margin-left: 10px">
            Load
        </button>
        <div id="controllers" role="navigation">
            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                <div class="controller" id="${c.toString().substring(11)}"
                     draggable="true"
                     style="position: absolute; top:70px; left:120px; padding: 5px">
                    <g:link controller="${c.logicalPropertyName}">${c.toString().substring(11)}</g:link>
                </div>
            </g:each>
        </div>
    </div>

    <div id="controllerCanvas"
         style="position: absolute; top: 140px; width: 100%; height: 90%; border: 2px solid lavender; background-color: #e8e8da" >
    </div>

    <script>
        savePositions = function() {
            let controllers = document.getElementsByClassName("controller")
            let controllerPositions = []
            for (let i = 0; i < controllers.length; i++) {
                let id = controllers[i].id
                let y = controllers[i].style.top
                let x = controllers[i].style.left
                controllerPositions[i] = {id:id, x:x, y:y};
            }
            localStorage.setItem('controlerPositions', JSON.stringify(controllerPositions))
        }

        loadPositions = function() {
            let controllerPositions = JSON.parse(localStorage.getItem('controlerPositions'))
            for (let i = 0; i < controllerPositions.length; i++) {
                let controller = document.getElementById(controllerPositions[i].id)
                let controllerCanvas = document.getElementById("controllerCanvas")
                controllerCanvas.appendChild(controller)
                controller.style.top = controllerPositions[i].y
                controller.style.left = controllerPositions[i].x
            }
        }

        onload = function() {
            loadPositions()
        }

        let controllers = document.getElementsByClassName("controller")
        for (let i = 0; i < controllers.length; i++) {
            controllers[i].addEventListener('dragstart', dragStart)
        }
        function dragStart(e) {
            e.dataTransfer.setData('text/plain', e.target.text);
        }

        const dropCanvas = document.getElementById("controllerCanvas")
        dropCanvas.addEventListener('dragenter', dragEnter)
        dropCanvas.addEventListener('dragover', dragOver)
        dropCanvas.addEventListener('dragleave', dragLeave)
        dropCanvas.addEventListener('drop', drop)

        function dragEnter(e) {
            e.preventDefault();
            e.target.classList.add('drag-over');
        }

        function dragOver(e) {
            e.preventDefault();
            e.target.classList.add('drag-over');
        }

        function dragLeave(e) {
            e.target.classList.remove('drag-over');
        }

        function drop(e) {
            e.preventDefault();
            e.target.classList.remove('drag-over');
            const id = e.dataTransfer.getData('text/plain');
            const item = document.getElementById(id);
            e.target.appendChild(item)
            item.style.top = e.pageY -160 + 'px';
            item.style.left = e.pageX -80 + 'px';
        }
    </script>
</body>
</html>

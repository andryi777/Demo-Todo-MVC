import java.text.SimpleDateFormat

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()

pipeline {

    agent any
    
    tools {
        maven 'M3'
        jdk 'jdk21'
    }
    
    options {
		buildDiscarder(logRotator(numToKeepStr: '20'))
	    disableConcurrentBuilds()
	}
    
    stages {
	
        stage ('Build') {
            steps {
                sh ("mvn -X clean verify")
            }
        }
        
		stage("Ejecutar Pruebas") {
            steps {
	            sh ("mvn test -Denvironments=local_chrome -Dcucumber.features='src/test/resources/features/' -Dcucumber.filter.tags='${ESCENARIO}' -Dcucumber.plugin='json:target/site/result.json' -Dcucumber.glue='demo'")
			}
        }
        
        stage ('Reporte') {
        	steps {
        		script {
					try {
                     	sh "mvn serenity:aggregate"
                    	publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                        echo 'Reporte realizado con exito'
                    }

                    catch (ex) {
                        echo 'Reporte realizado con Fallos'
                        error ('Failed')
                    }
                }
            }
        }
    }
}
pipeline{
    agent any
    tools{
        maven "maven"
    }
    stages{
        stage("Build Maven Project"){
            steps{
            script{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/saikumarjd/demoRest']]])
                bat 'mvn clean install'
                }
            }
        }
       stage("Build Docker Image"){
            steps{
                script{
                bat 'docker build -t sai96266/demorest .'
                }
            }
       }
//        stage("Scanning docker image"){
//             steps{
//                 bat 'docker scan --file Dockerfile sai96266/demorest '
//             }
//        }
       stage("push docker image to hub"){
            steps{
            script{
                 bat 'docker login -u sai96266 -p Tsunami9@'
                bat 'docker push sai96266/demorest'
                }
            }
       }
       stage("Deploying image on k8"){
            steps{
                script{
                    kubernetesDeploy (configs: 'deploymentservice.yaml', kubeconfigId: 'KubernetesCred')
                }
            }
       }
    }

}
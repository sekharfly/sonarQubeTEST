
1) Download and extract sonarcube from the using this url: https://www.sonarqube.org/downloads/ (SonarQube 7.8) Its required either java 7 or 8
2) Run <installDir>/bin/<yourOS>/sonar.sh start or <installDir>\bin\<yourOS>\StartSonar.bat if on Windows. 
   The server might take a while to start even after the “Started SonarQube” message appears.
3) Browse to http://localhost:9000.
4) Log in with the following credentials:
	Username: admin
	Password: admin
	
5) Download our Custom Quality Profile : https://mulesoft.github.io/connector-certification-docs/advanced/files/quality-profile.xml
6) Go to the Quality Profiles tab and Click restore top right upload above downloaded file(point 5).
7) Then choose the Quality Profile file that you downloaded, name it "Anypoint Connectors Profile" and click Create.
8) When you see the profile in the list click in Set as Default.
9) Add profile maven configuration in settings.xml file(in .m2 folder)

		<profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <!-- Optional URL to server. Default value is http://localhost:9000 -->
                <sonar.host.url>
                  http://localhost:9000
                </sonar.host.url>
            </properties>
        </profile>
10) You testing project must be in github same as your local project.
11) Runyour project: open command promt in your project location and run command: mvn clean verify sonar:sonar
or  mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent
	test -Dmaven.test.failure.ignore=true -Dtest="FunctionalTestSuite,ConnectorconfigTestCases"
	-DPARDOT_CREDENTIALS=automation-credentials.properties && mvn install && mvn sonar:sonar
# Calculator Project
made on IntelliJ

## Notes:

To build a JAR on IntelliJ: 
- File -> Project Structure
  - Hit the + icon to add a new JAR from existing modules
  - Specify main class and click OK

To build a JAR on Commandline: 
- Prepare TC-MANIFEST.MF file
  - Contains: Main-Class: {package where main is located}
  - Example: Main-Class: com.calculator.calculator
- jar cvmf TC-MANIFEST.MF {name of JAR} {location of root of project}

To run JAR on Commandline: 
- java -jar {name of JAR}

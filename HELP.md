# Java Google Translator Method

##Methode:
######src/main/java/com/example/translatorproject/TranslatorService.java >> translateText

Dependencies:

Dependencies on Maven:

    <dependencies>

        <dependency>
            <groupId>com.github.goxr3plus</groupId>
            <artifactId>java-google-speech-api</artifactId>
            <version>8.0.0</version>
        </dependency>

        <dependency>
            <groupId>org.jsoup</groupId>
            <artifactId>jsoup</artifactId>
            <version>1.16.2</version>
        </dependency>
        
    </dependencies>

    <repositories>
        
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>

    </repositories>


 

Dependencies on Gradle:

     dependencies {
        implementation 'com.github.goxr3plus:java-google-speech-api:8.0.0'
        implementation 'org.jsoup:jsoup:1.16.2'
     }

     repositories {
        maven { url 'https://jitpack.io' }
     }
Test / publishArtifact := false

publishTo := Some("Sonatype Nexus Repository Manager" at "https://nexus.kazan.myworldline.com/repository/messaging-maven-releases")
credentials += Credentials(Path.userHome / ".ivy2" / ".kazan_nexus_credentials")

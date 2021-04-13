Test / publishArtifact := false

// Note: he final slash '/' is important to really publish uploaded files.
// Otherwise the uploaded files are in 'unpublished' state and require
// manual publishing inside the bintray account.
publishTo := Some("Bintray API Realm" at s"https://api.bintray.com/maven/worldline-messaging-org/maven/${name.value}/;publish=1")
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

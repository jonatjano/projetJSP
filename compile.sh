cd WEB-INF/classes
find . -type f -name "*.java" > sources.list
javac @sources.list -encoding "UTF-8"

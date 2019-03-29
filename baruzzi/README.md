# Build
mvn clean package && docker build -t it.ciacformazione/baruzzi .

# RUN

docker rm -f baruzzi || true && docker run -d -p 8080:8080 -p 4848:4848 --name baruzzi it.ciacformazione/baruzzi 
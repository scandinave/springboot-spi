# springboot-spi
Exemple projet that use Service Provider Interface in a Springboot application to allow plugin architecture.

## Test

```shell
mvn clean package
```

Take the jar `api/target/api-1.0.0-SNAPSHOT.jar` and place it inside a directory of your choice. 
You can then launch the app with 

```shell
mkdir ~/springboot-spi
cp ./api/target/api-1.0.0-SNAPSHOT.jar ~/sprinboot-spi
cd ~/springboot-spi
java -cp api-1.0.0-SNAPSHOT.jar org.springframework.boot.loader.PropertiesLauncher
```

Go to [http://localhost:8080/plugins](http://localhost:8080/plugins). Nothing is return. Then add a lib folder next to the api jar 
and add the services jar inside it.

```shell
mkdir ~/springboot-spi/lib
cp ./services/services-1.0.0-SNAPSHOT.jar ~/sprinboot-spi/lib
cd ~/springboot-spi
java -cp api-1.0.0-SNAPSHOT.jar org.springframework.boot.loader.PropertiesLauncher
```

Result must be : 

````json
[
  {"name":"Foo","description":"A really cool foo plugin","links":[]},
  {"name":"Bar","description":"Another really cool bar plugin","links":[]}
]
````
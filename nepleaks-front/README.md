# nepleaks by prayagupd

## prerequisites

[emacs cider](https://github.com/clojure-emacs/cider#via-packageel)

[lein(ingen)][1] 1.7.0 or above.

[1]: https://github.com/technomancy/leiningen

## installing lein 

[Installing lein 1.7.1 described here](http://prayag-waves.blogspot.com.au/2013/01/installing-lein-on-ubuntu-1210.html)

for lein tasks

```
$ lein help
```

## download dependencies

    lein deps 

which will download all required dependencies.

But don't forget to configure `~/.m2/settings.xml` if [proxy](http://maven.apache.org/guides/mini/guide-proxies.html) is being used. Have a look at lein [issue#283](https://github.com/technomancy/leiningen/issues/283). 

    <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">

    <!-- proxies
         | This is a list of proxies which can be used on this machine to connect to the network.
         | Unless otherwise specified (by system property or command-line switch), the first proxy
         | specification in this list marked as active will be used.
         |-->
        <proxies>
          <proxy>
          <id>optional</id>
          <active>true</active>
          <protocol>http</protocol>
          <!--      <username>prayag</username>
                    <password></password>
          -->
          <host>10.**.***.**5</host>
          <port>8080</port>
          <nonProxyHosts>google.com|github.com</nonProxyHosts>
          </proxy>
        </proxies>

    </settings>



## run webapp

To start a web server for the application, fire:

    $ lein ring server 8443

## License

Copyright © 2013 pseudononymous-upd

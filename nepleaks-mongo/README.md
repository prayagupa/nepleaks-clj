https://raw.githubusercontent.com/mongodb/docs-assets/primer-dataset/primer-dataset.json

```

docker build -t mongodb . && docker -it run mongodb

docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS               NAMES
247511fb9548        mongodb             "/entrypoint.sh mongo"   2 minutes ago       Up 2 minutes        27017/tcp           serene_shockley

docker exec -it 247511fb9548 bash

```

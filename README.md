# kafka-publisher
Apache Kafka Publisher Example using SpringBoot

# start zookeeper.start bat file like below
zookeeper-server-start.bat D:\DEV-SOFTWARES\kafka_2.12-1.1.0\config\zookeeper.properties

# start kafka server
kafka-server-start.bat D:\DEV-SOFTWARES\kafka_2.12-1.1.0\config\server.properties

# Create Topic:
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic javatechie

# Produce a message 
kafka-console-producer.bat --broker-list localhost:9092 --topic javatechie

# Consume a message
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic javatechie

![kafka_serialization_desrialization](https://github.com/rtls-net/kafka-publisher-spring-boot-serialization/assets/147226341/dfc67d0a-3908-48f0-9827-48e9087419c8)


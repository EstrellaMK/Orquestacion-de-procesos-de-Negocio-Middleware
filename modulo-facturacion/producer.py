# Importando paquetes necesarios
from kafka import KafkaProducer
import json

def produce_message(topic="",msg=""):
    # Mi productor
    producerPy = KafkaProducer(bootstrap_servers =['localhost:9092'],
                    value_serializer=lambda v: json.dumps(v).encode('utf-8'), 
                    api_version=(0,10))
    producerPy.send(topic, msg)


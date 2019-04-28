Run com.assement.waldo.PhotoProcessorReceiverApplication

This will launch a Spring Boot runtime which will listen for messages on the RabbitMQ queue. 
It will then process each message and create a thumbnail in the '.../photo-processor-receiver-java/waldo-app-thumbs' directory.
It will also write an entry to the photo_thumbnails table and update the entry in the photo table with the status.
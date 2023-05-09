package com.backend.core.config

//@Component
//class KafkaConsumer {
//    @KafkaListener(topics = ["reservation"], groupId = "reservation_id")
//    fun listen(message: String): String {
//        return message
//    }
//}
//
//@Component
//class KafkaProducer(
//    private val kafkaTemplate: KafkaTemplate<String, String>
//) {
//    fun sendMessage(topic: String, message: String) {
//        kafkaTemplate.send(topic, message)
//    }
//}

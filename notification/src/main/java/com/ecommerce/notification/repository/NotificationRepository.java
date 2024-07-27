package com.ecommerce.notification.repository;

import com.ecommerce.notification.enitity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {

}

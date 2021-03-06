/*
 * Copyright 2021 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.awsqueue.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.jmix.awsqueue.utils.LocalDateTimeDeserializer;
import io.jmix.awsqueue.utils.LocalDateTimeSerializer;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.DateTimeFormat;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JmixEntity(annotatedPropertiesOnly = true)
public class QueueInfo {

    @JsonIgnore
    @JmixGeneratedValue
    @JmixProperty(mandatory = true)
    @JmixId
    private UUID id;

    @JsonIgnore
    @InstanceName
    @JmixProperty(mandatory = true)
    private String name;

    @JsonIgnore
    @JmixProperty(mandatory = true)
    private String url;

    @JsonIgnore
    @JmixProperty(mandatory = true)
    private Integer type;

    @JsonIgnore
    @JmixProperty
    private Integer status;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("CreatedTimestamp")
    @JmixProperty
    private LocalDateTime created;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("LastModifiedTimestamp")
    @JmixProperty
    private LocalDateTime lastUpdate;

    @JsonProperty("MaximumMessageSize")
    @Max(message = "{msg://QueueInfo.maximumMessageSize.validation}", value = 262144)
    @Min(message = "{msg://QueueInfo.maximumMessageSize.validation}", value = 1024)
    @JmixProperty
    private Long maximumMessageSize;

    @JsonProperty("MessageRetentionPeriod")
    @Max(message = "{msg://QueueInfo.messageRetentionPeriod.validation}", value = 1209600)
    @Min(message = "{msg://QueueInfo.messageRetentionPeriod.validation}", value = 60)
    @JmixProperty
    private Long messageRetentionPeriod;

    @JsonProperty("VisibilityTimeout")
    @Max(message = "{msg://QueueInfo.visibilityTimeout.validation}", value = 43200)
    @Min(message = "{msg://QueueInfo.visibilityTimeout.validation}", value = 0)
    @JmixProperty
    private Long visibilityTimeout;

    @JsonProperty("ApproximateNumberOfMessages")
    @JmixProperty
    private Long messagesAvailable;

    @JsonProperty("DelaySeconds")
    @Max(message = "{msg://QueueInfo.deliveryTime.validation}", value = 900)
    @Min(message = "{msg://QueueInfo.deliveryTime.validation}", value = 0)
    @JmixProperty
    private Long deliveryTime;

    @JsonProperty("ApproximateNumberOfMessagesNotVisible")
    @JmixProperty
    private Long messagesInFlight;

    @JsonProperty("ReceiveMessageWaitTimeSeconds")
    @Max(message = "{msg://QueueInfo.receiveMessageWaitTime.validation}", value = 20)
    @Min(message = "{msg://QueueInfo.receiveMessageWaitTime.validation}", value = 0)
    @JmixProperty
    private Long receiveMessageWaitTime;

    @JsonProperty("ApproximateNumberOfMessagesDelayed")
    @JmixProperty
    private Long messageDelayed;

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public Long getMessageDelayed() {
        return messageDelayed;
    }

    public void setMessageDelayed(Long messageDelayed) {
        this.messageDelayed = messageDelayed;
    }

    public QueueStatus getStatus() {
        return status == null ? null : QueueStatus.fromId(status);
    }

    public void setStatus(QueueStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public Long getReceiveMessageWaitTime() {
        return receiveMessageWaitTime;
    }

    public void setReceiveMessageWaitTime(Long recieveMessageWaitTime) {
        this.receiveMessageWaitTime = recieveMessageWaitTime;
    }

    public Long getMaximumMessageSize() {
        return maximumMessageSize;
    }

    public void setMaximumMessageSize(Long maximumMessageSize) {
        this.maximumMessageSize = maximumMessageSize;
    }

    public Long getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Long deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Long getMessageRetentionPeriod() {
        return messageRetentionPeriod;
    }

    public void setMessageRetentionPeriod(Long messageRetentionPeriod) {
        this.messageRetentionPeriod = messageRetentionPeriod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Long getVisibilityTimeout() {
        return visibilityTimeout;
    }

    public void setVisibilityTimeout(Long visibilityTimeout) {
        this.visibilityTimeout = visibilityTimeout;
    }

    public Long getMessagesInFlight() {
        return messagesInFlight;
    }

    public void setMessagesInFlight(Long messagesInFlight) {
        this.messagesInFlight = messagesInFlight;
    }

    public Long getMessagesAvailable() {
        return messagesAvailable;
    }

    public void setMessagesAvailable(Long messagesAvailable) {
        this.messagesAvailable = messagesAvailable;
    }

    public QueueType getType() {
        return type == null ? null : QueueType.fromId(type);
    }

    public void setType(QueueType type) {
        this.type = type == null ? null : type.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nebhale.letsmakeadeal;

import org.springframework.hateoas.Identifiable;

public final class Door implements Identifiable<Long> {

    private final Long id;

    private final Object monitor = new Object();

    private volatile DoorContent content;

    private volatile DoorStatus status;

    public Door(Long id, DoorContent content) {
        this.id = id;
        this.content = content;
        this.status = DoorStatus.CLOSED;
    }

    public Long getId() {
        return this.id;
    }

    public DoorContent getContent() {
        synchronized (this.monitor) {
            if (this.status == DoorStatus.OPEN) {
                return this.content;
            }
            return DoorContent.UNKNOWN;
        }
    }

    public DoorStatus getStatus() {
        synchronized (this.monitor) {
            return this.status;
        }
    }

    DoorContent peekContent() {
        return this.content;
    }

    void setStatus(DoorStatus status) {
        synchronized (this.monitor) {
            this.status = status;
        }
    }
}

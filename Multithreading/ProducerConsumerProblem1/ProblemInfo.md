# Producer-Consumer Problem in Java

## Introduction
The **Producer-Consumer Problem** is a classic synchronization problem in multithreading. This Java-based project implements a solution where multiple producer and consumer threads share a common queue, ensuring smooth data production and consumption without conflicts.

## Features
- Efficient handling of shared resources using synchronization.
- Prevents race conditions by using `wait()` and `notify()`.
- Dynamic queue management to handle varying production and consumption rates.

## Components
### 1. Shared Queue
A thread-safe queue is used to manage produced items.

### 2. Producer Thread
- Generates new data and adds it to the queue.
- Waits if the queue is full to prevent overflow.
- Notifies the consumer once new data is available.

### 3. Consumer Thread
- Fetches data from the queue for processing.
- Waits if the queue is empty to avoid errors.
- Notifies the producer once an item is consumed.

## Implementation Details
- The queue size is fixed to avoid memory overload.
- `synchronized` blocks ensure thread safety.
- `wait()` is used to pause a thread when needed.
- `notify()` is used to wake up waiting threads.


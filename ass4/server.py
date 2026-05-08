import socket, time
from datetime import datetime

HOST, PORT = '', 9999

s = socket.socket()
s.bind((HOST, PORT))
s.listen(10)

num = int(input("Enter number of clients: "))
clients = [s.accept()[0] for _ in range(num)]

# THIS INFINITE LOOP IS A DAEMON (SIMPLIFIED)
while True:
    times = []

    for c in clients:
        times.append(float(c.recv(1024).decode()))

    server_time = time.time()
    avg = (sum(times) + server_time) / (len(times) + 1)

    for i, t in enumerate(times):
        print(f"Client {i+1} Time:", datetime.fromtimestamp(t).strftime('%H:%M:%S'))

    print("Server Time:", datetime.fromtimestamp(server_time).strftime('%H:%M:%S'))
    print("Average Time:", datetime.fromtimestamp(avg).strftime('%H:%M:%S'))
    print("\n")

    for i, c in enumerate(clients):
        c.send(str(avg - times[i]).encode())



#         What is clock synchronization?
# Adjusting clocks of distributed systems to same time.
# 2. What is Berkeley Algorithm?
# Centralized clock synchronization algorithm.
# 3. Who acts as master in Berkeley Algorithm?
# One selected node acts as master.
# 4. What do slave nodes do?
# Send their local times to master.
# 5. How does master synchronize clocks?
# Calculates average time difference and broadcasts corrected time.
# 6. Is Berkeley algorithm centralized?
# Yes.
# 7. What is UTC?
# Universal Coordinated Time.
# 8. Difference between internal and external synchronization?
# ● Internal: synchronize within system
# ● External: synchronize with UTC reference
# 9. Advantage of Berkeley algorithm?
# No need of external UTC clock.
# 10. Limitation of Berkeley algorithm?
# Master node failure affects synchronization.
# 11. What is Cristian’s Algorithm?
# Method for fetching client clock times.
# 12. What is latency?
# Delay in communication.
# 13. What are outliers?
# Abnormal clock values deviating from average.
# 14. Why synchronization is needed?
# To coordinate distributed processes.
# 15. What happens if clocks differ?
# Inconsistency in distributed operations.
# 16. What language was used in assignment?
# Python.
# 17. What is socket programming?
# Communication between systems using sockets.
# 18. What is master-slave architecture?
# One master controls multiple slave nodes.
# 19. Applications of synchronization?
# Distributed databases, banking, cloud systems.
# 20. Main conclusion of Berkeley algorithm?
# All systems maintain approximately same time.




# A distributed system consists of multiple computers connected through a network that
# coordinate their actions using message passing. Since each system has its own internal clock,
# differences in time (clock drift) can occur, leading to inconsistencies. To maintain coordination
# and proper execution, clock synchronization is essential.
# Clocks in distributed systems are synchronized using physical clocks based on UTC
# (Coordinated Universal Time) as a reference. Synchronization ensures all nodes maintain a
# consistent notion of time.
# Types of Clock Synchronization
# 1. External Synchronization
#  Uses an external reference clock (like UTC)
#  Nodes adjust their clocks according to the reference
# 2. Internal Synchronization
#  Nodes synchronize with each other
#  Adjust clocks based on mutual agreement
# Clock Synchronization Algorithms
# Centralized Algorithms
#  Use a single time server
#  Example: Berkeley Algorithm
#  Limitation: Single point of failure
# Distributed Algorithms
#  No central server
#  Nodes coordinate among themselves
#  Example: NTP, averaging algorithms
# Berkeley Algorithm Overview
# The Berkeley Algorithm is a centralized clock synchronization technique where one node
# acts as a master, and others act as slave nodes. It is used when systems do not have access
# to an accurate external time source.
# Working of Berkeley Algorithm
# 5
# 1. Master Selection
# ○ One node is selected as the master using a leader election algorithm
# 2. Polling Slave Nodes
# ○ Master sends requests to all slave nodes
# ○ Each node replies with its local time
# 3. Time Difference Calculation
# ○ Master calculates time differences between its clock and each slave clock
# 4. Average Time Computation
# ○ Master computes the average of all time differences
# ○ Ignores faulty or extreme values (outliers)
# 5. Broadcast Adjustment
# ○ Master sends adjustment values (not exact time) to all nodes
# ○ Each node updates its clock accordingly
# Key Features
#  Does not rely on external UTC source
#  Reduces clock drift among nodes
#  Improves consistency in distributed systems
#  Uses average time correction
# Limitations
#  Single point of failure (master node)
# Communication delay affects accuracy
#  Requires re-election if master fails
# Scope of Improvements
#  Ignore outliers in time calculations
#  Use backup master node
#  Send relative time adjustments instead of exact time
#  Reduce latency in communication
# Implementation (Python)
#  Master acts as clock server
#  Clients send their local time
#  Master calculates average and sends correction
#  Clients update their clocks
# This demonstrates practical implementation of synchronization in distributed systems.

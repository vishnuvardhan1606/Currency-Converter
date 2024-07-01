import psutil
import time
import matplotlib.pyplot as plt

# Initialize empty lists to hold historical data
cpu_percents = []
mem_percents = []
disk_percents = []
net_bytes_sent = []
net_bytes_recv = []
timestamps = []

# Loop forever and log system resource utilization
while True:
    # Get current system resource utilization
    cpu_percent = psutil.cpu_percent()
    mem_percent = psutil.virtual_memory().percent
    disk_percent = psutil.disk_usage('/').percent
    net_io_counters = psutil.net_io_counters()
    net_bytes_sent.append(net_io_counters.bytes_sent)
    net_bytes_recv.append(net_io_counters.bytes_recv)
    timestamp = time.time()

    # Log current utilization
    print(f'CPU: {cpu_percent}%, Memory: {mem_percent}%, Disk: {disk_percent}%, Sent: {net_bytes_sent[-1]}, Received: {net_bytes_recv[-1]}')

    # Add current utilization to historical data
    cpu_percents.append(cpu_percent)
    mem_percents.append(mem_percent)
    disk_percents.append(disk_percent)
    timestamps.append(timestamp)

    # Wait for one second before logging again
    time.sleep(1)

    # Plot historical data
    plt.clf()
    plt.subplot(2, 2, 1)
    plt.plot(timestamps, cpu_percents)
    plt.title('CPU Utilization')
    plt.xlabel('Time (s)')
    plt.ylabel('Utilization (%)')
    plt.subplot(2, 2, 2)
    plt.plot(timestamps, mem_percents)
    plt.title('Memory Utilization')
    plt.xlabel('Time (s)')
    plt.ylabel('Utilization (%)')
    plt.subplot(2, 2, 3)
    plt.plot(timestamps, disk_percents)
    plt.title('Disk Utilization')
    plt.xlabel('Time (s)')
    plt.ylabel('Utilization (%)')
    plt.subplot(2, 2, 4)
    plt.plot(timestamps, net_bytes_sent, label='Sent')
    plt.plot(timestamps, net_bytes_recv, label='Received')
    plt.title('Network Bandwidth Utilization')
    plt.xlabel('Time (s)')
    plt.ylabel('Bytes')
    plt.legend()
    plt.tight_layout()
    plt.pause(0.01)

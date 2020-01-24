import socket

port = 80
host = 'slashdot.org'

request = ['GET / HTTP/ 1.0',
           'Accept: text/html',
           '\r\n']

with socket.socket(socket.AF_INET, socket.SOCK_STREAM, 0) as s:
    s.connect( (host, port) )
    print("Connected to {}".format(host))

    s.sendall("\r\n".join(request).encode('iso_8859_1'))
    full = b'
    while message:
        full+= message
        message = s.recv(1024)
    print("Got {} bytes from {}".format(len(full),host))
    full = full.decode('iso_8859_1')
    print(message)



## ip
```text
public int getIpAddressAsInt() {
    InetAddress inetAddress = null;
    String host = this.ipAddress;
    if (host == null) {
        host = this.hostname;
    }
    try {
        inetAddress = InetAddress.getByName(host);
    }
    catch (final UnknownHostException e) {
        throw new IllegalArgumentException(e);
    }
    return ByteBuffer.wrap(inetAddress.getAddress()).getInt();
}
```
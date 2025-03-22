import { TcpSocketPlugin } from 'capacitor-socket-tcp';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    TcpSocketPlugin.echo({ value: inputValue })
}

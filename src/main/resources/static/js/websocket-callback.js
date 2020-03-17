window.onload = function() {

    setInterval(function() {
        Wicket.WebSocket.send("test");
    }, 1000)
}
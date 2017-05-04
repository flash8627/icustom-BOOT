<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<script src="http://cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script
<body>
s
</body>
<script>
    var url = "ws://localhost:8080/hello";
    function connect() {
        ws = (url.indexOf('sockjs') != -1) ?
                new SockJS(url, undefined, {protocols_whitelist: transports}) : new WebSocket(url);
        ws.onopen = function () {
            // setConnected(true);
            log('Info: connection opened.');
        };
        ws.onmessage = function (event) {

            data = $.parseJSON(event.data);
            createDate = new Date(data.createDate);
            var jsonData = [createDate.getTime(), data.jvmUseHeap];
            var jsonMemFreeData = [createDate.getTime(), data.jvmMemFree];
            highjvmHeapInfo.series[0].addPoint(jsonData, true, true);
            highjvmHeapInfo.series[1].addPoint(jsonMemFreeData, true, true);
        };
        ws.onclose = function (event) {
            //setConnected(false);
            log('Info: connection closed.');

            log(event);
        };
    }
    connect();

</script>
</html>
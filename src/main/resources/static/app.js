var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
}

function setActivated(activated) {
    $("#activateHack").prop("disabled", activated);
    $("#deactivateHack").prop("disabled", !activated);
    if (activated) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/instruction', function (instruction) {
            showGreeting(instruction.body);
        });
        stompClient.subscribe('/topic/map', function (map) {
            showMap(map.body);
        });
        stompClient.subscribe('/topic/activator', function (active) {
            showActive(active.body);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function activateHack() {

    $.ajax({url: "/activator", type: "post", data: "true", contentType: 'text/html', success: function () {

            setActivated(true);
        }});
}

function deactivateHack() {

    $.ajax({url: "/activator", type: "post", data: "false", contentType: 'text/html', success: function () {

            setActivated(false);
        }});
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#activeInstructionWS").html("<tr><td>" + message + "</td></tr>");
}

function showMap(message) {
    $("#realTimeMap").html(message);
}

function showActive(active) {
    $("#isActive").html(active);
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#activateHack" ).click(function() { activateHack(); });
    $( "#deactivateHack" ).click(function() { deactivateHack(); });
});
var exec = require('cordova/exec');

function PurpleRobotIntent() {}

PurpleRobotIntent.prototype.send = function send() {
  function success() {}

  function error() {}

  exec(success, error, 'PurpleRobotIntent', 'send', []);
}

window.PurpleRobotIntent = PurpleRobotIntent;

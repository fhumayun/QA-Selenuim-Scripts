var self = require("sdk/self");

var button = require("sdk/ui/button/action").ActionButton({
  id: "style-tab",
  label: "Style Tab",
  icon: {
    "16": "./icon16.png",
    "32": "./icon32.png",
    "64": "./icon64.png"
  },
  onClick: function() {
    require("sdk/tabs").activeTab.attach({
      contentScriptFile: self.data.url("hic-id.js")
    });
  }
});
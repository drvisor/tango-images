# tango-images
Adapters to work with tango-icon-theme

Example of usage:
<pre>
private class SendAction extends AbstractAction {
        public SendAction() {
            putValue(NAME, "Send");
            putValue(SHORT_DESCRIPTION, "Send message into chat");
            putValue(SMALL_ICON, Tango.small(TangoIconName.mail_send_receive));
        }
...
</pre>


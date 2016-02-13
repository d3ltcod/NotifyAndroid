/**
 * Created by adam on 12/02/16.
 */
(function (exports) {

    'use strict';

    var STORAGE_KEY = 'PUSHWOOSH_NOTIFICATIONS';

    exports.notificationsStorage = {
        fetch: function () {
            return JSON.parse(localStorage.getItem(STORAGE_KEY) || '[]');
        },
        save: function (notifications) {
            localStorage.setItem(STORAGE_KEY, JSON.stringify(notifications));
        }
    };

})(window);
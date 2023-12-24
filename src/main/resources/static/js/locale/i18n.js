String.prototype.format = function() {
    var args = arguments;
    return this.replace(/{([0-9]+)}/g, function(match, index) {
        return typeof args[index] == 'undefined' ? match : args[index];
    });
};

const i18n = {
    __: function(phrase, ...params) {
        let loadedLanguage = window.__lang;
        debugger;
        if (!loadedLanguage){
            return phrase;
        }
        let translation = loadedLanguage[phrase]
        if (translation === undefined) {
            translation = phrase
        } else if (params && params.length) {
            translation = translation.format(...params)
        }
        return translation
    }
}

window.i18n = i18n;
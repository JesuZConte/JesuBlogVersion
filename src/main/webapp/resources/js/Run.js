"use strict";
var main= App.Main();
main.init();

var modalCrateNew= App.ModalCreateNew();
modalCrateNew.init();

var modalShowNew=App.ModalShowNew();
modalShowNew.init();

var loadData = App.LoadData().createNews();
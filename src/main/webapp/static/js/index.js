function addSimpleQuestion(){
	document.getElementById('add-rc-passage').style.display="none";
	document.getElementById('add-simple-question').style.display="block";
}
function addRCPassage(){
	document.getElementById('add-simple-question').style.display="none";
	document.getElementById('add-rc-passage').style.display="block";
}
function addSelected(combo){
	if(combo.value == '1')
	{
		addSimpleQuestion();
	}
	else if(combo.value == '2'){
		addRCPassage();
	}

}
function visualizzaDocumenti() {
    fetch("http://localhost:8080/mycloud-master/resources/documents",
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${localStorage.getItem('token')}`
                },
//                body: frm,
                method: "get"
            })
            .then(response => response.json())
            .then(json => {
                console.log(json);
                document.querySelector("#contenitoreDocs").innerHTML = "";
                creaTabellaDaJson(json, "nomeFile,id,titolo", "tab1", "tabella", "#contenitoreDocs");
            })
//            .then(response => {
//                document.querySelector("#contenitoreDocs").innerHTML = "";
//                creaTabellaDaJson(response(), "id,titolo,nomeFile,tags", "tab1", "tabella", "#contenitore");
//            })
//            .then(response => {
//                if (response.status === 200) {
//                    document.querySelector("#contenitoreDocs").innerHTML = response;
//                    creaTabellaDaJson(response.json(), "id,titolo,nomeFile,tags", "tab1", "tabella", "#contenitore");
//                } else {
//                    console.log(response);
//                }
//            })
            .catch(res => console.error(res));
}

function creaTabellaDaJson(oggJson, listaCampi, idTabella, classeTabella, contenitore = "body") {
    let tabella = document.createElement("table");
    tabella.id = idTabella;
    tabella.className = classeTabella;  //da verif

    let vCampi = listaCampi.split(",");

    //riga intestazione
    let tHead = document.createElement("thead");
    let riga = document.createElement("tr");
    vCampi.forEach(function (campo, i) {
        let th = document.createElement("th");
        th.innerHTML = campo;
        riga.append(th);
    });
    tabella.append(tHead);
    tHead.append(riga);

    let tBody = document.createElement("tBody");
    oggJson.forEach(function (record, i) {
        let rigaRecord = document.createElement("tr");
        vCampi.forEach(function (campo, j) {
            let cella = document.createElement("td");
            cella.innerHTML = oggJson[i][campo];  //record[campo]
            rigaRecord.append(cella);
        });
        tBody.append(rigaRecord);
    });

    tabella.append(tBody);

    //append della tabella al contenitore
    document.querySelector(contenitore).append(tabella);
}


function caricaFile() {
    let frm = new FormData();
    frm.append("titolo", document.querySelector("#titolo").value);
    frm.append("file", document.querySelector("#file").files[0], document.querySelector("#file").files[0].name);
    fetch("http://localhost:8080/mycloud-master/resources/documents",
            {
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('token')}`
                },
                body: frm,
                method: "post"
            })
            .then(response => {
                if (response.status === 200) {
                    window.alert("File caricato correttamente");
                } else {
                    console.log(response);
                }
            })
            .catch(res => console.error(res));
}



function visualizzaDocumenti() {
    fetch("http://localhost:8080/mycloud-master/resources/documents",
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${localStorage.getItem('token')}`
                },
                method: "get"
            })
            .then(response => response.json())
            .then(json => {
                console.log(json);
                //prelevati i dati una funzione da implementare si occupa della loro visualizzazione
                document.querySelector("#contenitoreDocs").innerHTML = json;

            })

            .catch(res => console.error(res));
    
}

/**
 * Implementare funzione per la condivisione del documento con un utente
 * selezionato
 * Chiamata a servizio REST per la creazione della condivisione
 */
function shareDocument(){
    // TODO
}


/**
 * Implementare Funzione per la connessione al servizio REST
 * per la visualizzione dei file Condivisi
 * da altri utenti
 */
function visualizzaDocumentiCondivisi() {
    // TODO
}

/**
 * Implementazione Funzione per la connessione al servizio REST
 * per permette l'inserimento di uno o più tag 
 * al documento selezionato
 */
function tagDocumento() {
    // TODO
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
    
    /* TODO
    Implementare funzione per verificare la dimensione del file che si
    vuole caricare con la limitazione che il singolo file sia <=100 MB */
}

/**
 * Implementazione Funzione per la ricerca
 * 
 */
function searchDocument() {
    // Rilevazione tipo di ricerca
    if (document.getElementById("option-one").checked) {
        searchByName();
    } else {
        searchbyTag();
    }
}

/**
 * Implementazione funzione per la ricerca del documento/i
 * avendo inserito un nome
 * La funzione chiamerà il servizio REST per la verifica
 * della presenza nella tabella Documenti
 */
function searchByName(){
    // TODO
}

/**
 * Implementazione funzione per la ricerca del documento/i
 * avendo inserito un tag
 * La funzione chiamerà il servizio REST per la verifica
 * della presenza nella tabella Documenti
 */
function searchbyTag(){
    // TODO
}


/**
 * Implementazione funzione per la connessione al relativo servizio REST
 * per l'eliminazione dal cloud di uno o più documenti
 */
function deleteDocument(){
    // TODO
}

/**
 * Implementazione funzione per la connessione al relativo servizio REST
 * per effettuare il download di uno o più file presenti sul cloud
 */
function downloadFile(){
    // TODO
}

/**
 * Implementazione funzione per la procedura di logout
 * dell'utente corrente
 * e richiamo della pagina di Login/Registrazione
 */
function logoutUser(){
    //TODO
    document.location = "index.html";
}
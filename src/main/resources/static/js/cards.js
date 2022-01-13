
const CardType = {
    TREFLE: {
        name: "clubs",
        css: "&clubs;"
    },
    CARREAU: {
        name: "diams",
        css: "♦"
    },
    COEUR: {
        name: "hearts",
        css: "&hearts;"
    },
    PIQUE: {
        name: "spades",
        css: "&spades;"
    }
}

function getCardRow(card) {
    const cardType = CardType[card.color];
    const cardName = cardType.name;
    const cardCss = cardType.css;
    return "<Li><div class=\"card rank-" + card.rank + " " + cardName + "\">\n" +
        "            <span class=\"rank\">" + card.rank + "</span>\n" +
        "            <span class=\"suit\">" + cardCss + "</span>\n" +
        "        </div></Li>"
}

function formatValueOrder(values) {
    const result=[]
    values.forEach(e=>{
       switch (e){
           case 1:
               result.push('AS');
               break;
           case 11:
               result.push('J');
               break;
           case 12:
               result.push('Q');
               break;
           case 13:
               result.push('K');
               break;
           default:
               result.push(e);
               break;
       }
    });
    return result;
}

function clearDeck() {
    $("#shuffled-cards").empty();
    $("#sorted-cards").empty();
    $("#colororder").empty();
    $("#valueorder").empty();
}

function draw() {
    $.ajax({
        url: `http://localhost:8080/cards`
    }).then(function (data) {
        clearDeck();
        data.randomHand.cards.forEach(card => {
            $("#shuffled-cards").append(getCardRow(card));
        });
        data.sortedHand.cards.forEach(card => {
            $("#sorted-cards").append(getCardRow(card));
        })
        $("#colororder").append(data.colorOrder.join(', ').toLowerCase());
        $("#valueorder").append(formatValueOrder(data.valueOrder).join(', '));
    });
};
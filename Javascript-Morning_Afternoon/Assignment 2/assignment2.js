var squares = document.getElementsByClassName('square');
var buttons = document.getElementsByTagName('button');

var evenButton = buttons[0];
var multipleOfFiveButton = buttons[1];
var resetButton = buttons[2];

evenButton.addEventListener('click', () => {
    for(let i=1; i<=squares.length; i++)
    {
        squares[i-1].style.background = 'white';
    }

    for(let i=1; i<=squares.length; i++)
    {
        if(i%2 == 0)
        {
            squares[i-1].style.background = 'steelblue';
        }
    }
})

multipleOfFiveButton.addEventListener('click', () => {
    for(let i=1; i<=squares.length; i++)
    {
        squares[i-1].style.background = 'white';
    }

    for(let i=1; i<=squares.length; i++)
    {
        if(i%5 == 0)
        {
            squares[i-1].style.background = 'steelblue';
        }
    }
})

resetButton.addEventListener('click', () => {
    for(let i=1; i<=squares.length; i++)
    {
        squares[i-1].style.background = 'white';
    }
})
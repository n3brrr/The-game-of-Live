document.addEventListener("DOMContentLoaded", () => {
    cargarEstado();

    document.getElementById("next-gen").addEventListener("click", siguienteGeneracion);
    document.getElementById("reset").addEventListener("click", reiniciar);
    document.getElementById("toggle-auto").addEventListener("click", toggleAuto);
    document.getElementById("toggle-dark").addEventListener("click", toggleDarkMode);
});

async function cargarEstado() {
    const response = await fetch("/api/game-state");
    const gameState = await response.json();
    renderizarTablero(gameState.cells);
}

async function siguienteGeneracion() {
    const response = await fetch("/api/next-generation", { method: "POST" });
    const gameState = await response.json();
    renderizarTablero(gameState.cells);
}

async function reiniciar() {
    await fetch("/api/reset", { method: "POST" });
    cargarEstado();
}

function renderizarTablero(cells) {
    const gameBoard = document.getElementById("game-board");
    gameBoard.innerHTML = ""; // Limpiar el tablero existente

    cells.forEach((row, i) => {
        const rowDiv = document.createElement("div");
        rowDiv.classList.add("row");
        row.forEach((cell, j) => {
            const cellDiv = document.createElement("div");
            cellDiv.classList.add("cell");
            if (cell) {
                cellDiv.classList.add("alive");
            }
            rowDiv.appendChild(cellDiv);
        });
        gameBoard.appendChild(rowDiv);
    });

    // Configurar el tamaño del tablero dinámicamente
    gameBoard.style.gridTemplateColumns = `repeat(${cells[0].length}, 20px)`;
}

function toggleDarkMode() {
    document.body.classList.toggle("dark");
}
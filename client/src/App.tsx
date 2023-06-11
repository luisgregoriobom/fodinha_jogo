import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";

function App() {
  const [count, setCount] = useState(0);

  function connectToWebSocket() {
    console.log("conectando");

    const ws = new WebSocket("ws://localhost:8080");

    ws.onopen = () => {
      console.log("conectado");
    };

    ws.onmessage = (event) => {
      console.log(event.data);
    };

    ws.onclose = () => {
      console.log("desconectado");
    };

    ws.onerror = (error) => {
      console.log(error);
    };

    // ws.send("oi");
  }

  return (
    <>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Fodinha</h1>
      <div className="card">
        <p>
          <label>Sala</label>
          <input type="text" />
        </p>
        <button onClick={() => connectToWebSocket()}>conectar</button>
      </div>
    </>
  );
}

export default App;

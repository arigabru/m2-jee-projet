import './App.css';
import { Link, Routes, Route, BrowserRouter } from "react-router-dom";
import ConnectPage from './Connexion/ConnectPage';
import InscriptionPage from './Inscription/InscriptionPage';
import GameBoardPage from './GameBoard/GameBoardPage';
import RPS from './PFC/RPS';

function App() {
  return (
    <div className="App">    
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ConnectPage/>} />
        <Route path="/inscription" element={<InscriptionPage/>} />
        <Route path="/gameBoard" element={<GameBoardPage/>} />
        <Route path="/pfc" element={<RPS/>} />
      </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;

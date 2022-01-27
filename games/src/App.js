import './App.css';
import { Link, Routes, Route, BrowserRouter } from "react-router-dom";
import ConnectPage from './Connexion/ConnectPage';
import InscriptionPage from './Inscription/InscriptionPage';
import GameBoardPage from './GameBoard/GameBoardPage';
import RPS from './PFC/RPS';
import WarPage from './war/WarPage';
import ProfilePage from './Profile/ProfilePage';

function App() {
  return (
    <div className="App">    
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ConnectPage/>} />
        <Route path="/inscription" element={<InscriptionPage/>} />
        <Route path="/gameBoard" element={<GameBoardPage/>} />
        <Route path="/pfc" element={<RPS/>} />
        <Route path="/war" element={<WarPage/>} />
        <Route path="/profile" element={<ProfilePage/>} />
      </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;

import './App.css';
import { Link, Routes, Route, BrowserRouter } from "react-router-dom";
import ConnectPage from './Connexion/ConnectPage';
import InscriptionPage from './Inscription/InscriptionPage';


function App() {
  return (
    <div className="App">    
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ConnectPage/>} />
        <Route path="/inscription" element={<InscriptionPage/>} />
      </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;

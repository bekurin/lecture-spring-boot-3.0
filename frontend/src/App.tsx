import { BrowserRouter, Routes, Route } from 'react-router-dom';
import RouteContainer from './pages/route/RouteContainer';

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<RouteContainer/>}/>
        </Routes>
      </BrowserRouter>
  );
}

export default App;

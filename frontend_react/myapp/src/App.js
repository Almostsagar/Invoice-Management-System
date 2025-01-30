import './App.css';
import DataGridForHRC from './components/Datagrid';
import Footer from './components/Footer';
import Header from './components/Header';

function App() {
  return <div className="App">
    <Header/>
    <DataGridForHRC />
    <Footer/>
  </div>;

}

export default App;

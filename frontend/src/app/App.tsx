import React, { useState, useEffect } from 'react';
import Dashboard from './components/Dashboard';
import Navigation from './components/Navigation';
import SystemControl from './components/SystemControl';
import { LayoutDashboard, Camera, Settings, Activity } from 'lucide-react';

const App = () => {
  const [activeTab, setActiveTab] = useState('dashboard');

  return (
    <div className="min-h-screen bg-slate-950 text-slate-50 font-sans">
      <Navigation activeTab={activeTab} setActiveTab={setActiveTab} />
      
      <main className="container mx-auto px-4 py-8">
        <header className="mb-8">
          <h1 className="text-3xl font-bold bg-gradient-to-r from-blue-400 to-purple-500 bg-clip-text text-transparent">
            AI CAMERA CONTROL SYSTEM
          </h1>
          <p className="text-slate-400">Hệ thống giám sát vận hành thời gian thực v1.0.0</p>
        </header>

        {activeTab === 'dashboard' && <Dashboard />}
        {activeTab === 'system' && <SystemControl />}
      </main>
    </div>
  );
};

export default App;

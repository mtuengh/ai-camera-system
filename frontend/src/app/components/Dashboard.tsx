import React, { useState, useEffect } from 'react';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer, AreaChart, Area } from 'recharts';
import { Package, CheckCircle, Clock, AlertTriangle } from 'lucide-react';

const Dashboard = () => {
  const [metrics, setMetrics] = useState({
    processed: 1240,
    accuracy: 98.5,
    latency: 45,
    defects: 12
  });

  // Giả lập dữ liệu real-time nhảy số mỗi 2 giây
  useEffect(() => {
    const interval = setInterval(() => {
      setMetrics(prev => ({
        ...prev,
        processed: prev.processed + Math.floor(Math.random() * 5),
        latency: 40 + Math.floor(Math.random() * 10)
      }));
    }, 2000);
    return () => clearInterval(interval);
  }, []);

  return (
    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
      {/* Metric Cards */}
      <div className="bg-slate-900 p-6 rounded-2xl border border-slate-800">
        <div className="flex items-center gap-4">
          <div className="p-3 bg-blue-500/10 rounded-lg text-blue-500"><Package size={24} /></div>
          <div>
            <p className="text-sm text-slate-400">Bưu kiện xử lý</p>
            <p className="text-2xl font-bold">{metrics.processed}</p>
          </div>
        </div>
      </div>
      
      {/* Thêm các cards khác tương tự cho Accuracy, Latency, Defects... */}
      
      <div className="col-span-full bg-slate-900 p-6 rounded-2xl border border-slate-800 mt-6">
        <h3 className="text-lg font-semibold mb-6 text-blue-400">Độ trễ xử lý hệ thống (ms)</h3>
        <div className="h-64">
          <ResponsiveContainer width="100%" height="100%">
            <AreaChart data={Array.from({length: 20}, (_, i) => ({time: i, val: 40 + Math.random()*20}))}>
              <defs>
                <linearGradient id="colorVal" x1="0" y1="0" x2="0" y2="1">
                  <stop offset="5%" stopColor="#3b82f6" stopOpacity={0.3}/>
                  <stop offset="95%" stopColor="#3b82f6" stopOpacity={0}/>
                </linearGradient>
              </defs>
              <CartesianGrid strokeDasharray="3 3" stroke="#1e293b" />
              <XAxis dataKey="time" hide />
              <YAxis stroke="#94a3b8" fontSize={12} />
              <Tooltip contentStyle={{backgroundColor: '#0f172a', border: 'none'}} />
              <Area type="monotone" dataKey="val" stroke="#3b82f6" fillOpacity={1} fill="url(#colorVal)" />
            </AreaChart>
          </ResponsiveContainer>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
